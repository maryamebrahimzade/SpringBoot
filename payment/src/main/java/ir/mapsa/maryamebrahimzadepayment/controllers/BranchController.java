package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.dto.BranchDto;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import ir.mapsa.maryamebrahimzadepayment.services.BankInfoService;
import ir.mapsa.maryamebrahimzadepayment.services.BranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController extends AbstractController<Branch, BranchDto, BranchService> {

}
