package com.jimmypj.reggie_takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jimmypj.reggie_takeout.entity.AddressBook;
import com.jimmypj.reggie_takeout.mapper.AddressBookMapper;
import com.jimmypj.reggie_takeout.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
