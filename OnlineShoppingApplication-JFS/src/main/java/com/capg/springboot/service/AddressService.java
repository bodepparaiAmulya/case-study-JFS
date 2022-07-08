package com.capg.springboot.service;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;

public interface AddressService {
   public Address addAddress(Address add);
   public Address removeAddress(Address add);
   public Address updateAddress(Address add);
   public Address viewAllAddress(String add) throws AddressNotFoundException;
}
