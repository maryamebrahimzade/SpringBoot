package com.trans.telepardaz;

import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.LegalMerchant;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.models.merchant.PersonMerchant;
import com.trans.telepardaz.models.QrCode;
import com.trans.telepardaz.repositories.merchant.LegalMerchantRepository;
import com.trans.telepardaz.repositories.merchant.PersonMerchantRepository;
import com.trans.telepardaz.repositories.QRCodeRepository;
import com.trans.telepardaz.services.merchant.MerchantService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Import(TelepardazApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional(readOnly = false)
@EnableTransactionManagement
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase
@Rollback(false)
class TelepardazApplicationTests {
    @Autowired
    private QRCodeRepository qrCodeRepository;
    @Autowired
    private PersonMerchantRepository personMerchantRepository;
    @Autowired
    private LegalMerchantRepository legalMerchantRepository;
    @Autowired
    private MerchantService merchantService;

    @Test
    void contextLoads() {
    }
    PersonMerchant personMerchant = new PersonMerchant();
    private String qrCodeId;
    private String terminalId;
    @BeforeAll
    public void init() {
        personMerchant.setName("maryam");
        personMerchant.setPhone("22209318");
        personMerchant.setMobile("09920852138");
        personMerchant.setEmail("maryam.ebrahimzade@gmail.com");
        personMerchant.setIban("IR520170000000110528698006");
        this.personMerchantRepository.save(personMerchant);
        qrCodeId="1";
        terminalId="1000";
        generateQrCode();
    }

    private void generateQrCode() {
        QrCode qrCode = QrCode.builder()
                .qrCodeId(qrCodeId)
                .terminalId(terminalId)
                .merchant(personMerchant).build();
        this.qrCodeRepository.save(qrCode);
    }

    @Test
    public void findTerminalId_before_generateQRCode() throws ServiceException {
        //Act
        terminalId="1001";
        QrCode qrCode = qrCodeRepository.findByTerminalId(terminalId);
        //Assertion
        Assertions.assertThat(qrCode).isNull();
        qrCodeId="2";
        generateQrCode();
    }

    @Test
    public void findMerchant_before_generateQRCode() throws ServiceException {
        //Act
        Optional<Merchant> merchantOptional = merchantService.findById(1L);
        //Assertion
        Assertions.assertThat(merchantOptional).isNotEmpty();
    }

    @Test
    public void givenMerchantList_whenFindAll() {
        PersonMerchant person = new PersonMerchant();
        person.setName("arezo");
        person.setPhone("22209318");
        person.setMobile("09920852138");
        person.setEmail("maryam.ebrahimzade@gmail.com");
        person.setIban("IR520170000000110528698006");
        personMerchantRepository.save(person);
        //Act
        List<PersonMerchant> merchantList = personMerchantRepository.findAll();
        //Assertion
        Assertions.assertThat(merchantList).isNotNull();
        Assertions.assertThat(merchantList.size()).isEqualTo(2);
    }

    @Test
    public void givenMerchantObject_whenDeleteById_thenRemoveMerchant() {
        PersonMerchant person = new PersonMerchant();
        person.setName("asma");
        person.setPhone("22209318");
        person.setMobile("09920852138");
        person.setEmail("maryam.ebrahimzade@gmail.com");
        person.setIban("IR520170000000110528698006");
        personMerchantRepository.save(person);
        //Act
        personMerchantRepository.deleteById(person.getId());
        List<PersonMerchant> merchantList = personMerchantRepository.findAll();
        //Assertion
        Assertions.assertThat(merchantList.size()).isEqualTo(1);
    }

    @Test
    public void givenLegalMerchantList_whenFindAll_thenMerchantsList() {
        //Act
        List<LegalMerchant> merchantList = legalMerchantRepository.findAll();
        //Assertion
        Assertions.assertThat(merchantList).isEmpty();
    }

    @Test
    public void givenPersonMerchantObject_whenUpdateMerchant_thenReturnUpdatedMerchant(){
        //Act
        PersonMerchant savedMerchant = personMerchantRepository.findById(personMerchant.getId()).get();
        savedMerchant.setName("mariya");
        //Assertions
        org.assertj.core.api.Assertions.assertThat(savedMerchant.getName()).isEqualTo("mariya");
    }
}
