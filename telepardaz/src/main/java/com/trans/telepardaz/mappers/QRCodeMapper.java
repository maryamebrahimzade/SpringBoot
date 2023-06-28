package com.trans.telepardaz.mappers;


import com.trans.telepardaz.dtos.QRCodeDto;
import com.trans.telepardaz.models.QrCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeMapper extends BaseMapper<QRCodeDto, QrCode> {
}
