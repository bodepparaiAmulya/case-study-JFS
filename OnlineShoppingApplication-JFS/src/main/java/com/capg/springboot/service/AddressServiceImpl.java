package com.capg.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;
import com.capg.springboot.repository.AddressRepository;
@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired 
	private AddressRepository add_repo;
	
	
	/* Method: addAddress 
	 * Description: It adds the address of the user.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address.
     * Created By- Jyothi Prakash
     * Created Date -30-11-2021  
     */
	@Override
	public Address addAddress(Address add) {
		return add_repo.save(add);
		
	}
	
	/* Method: removeAddress 
	 * Description: It remove the address of the user.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address.
     * Created By- Jyothi Prakash
     * Created Date -30-11-2021  
     */
	@Override
	public Address removeAddress(Address add) {
		
	add_repo.delete(add);
	return add;
	}
	
	/* Method: updateAddress 
	 * Description: It update the address of the user.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address.
     * Created By- Jyothi Prakash
     * Created Date -30-11-2021  
     */
	@Override
	public Address updateAddress(Address add) {
		add_repo.save(add);
		return add;
	}
	
	/* Method: viewAllAddress 
	 * Description: It view all the address of the user with respective id.
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address.
     * Created By- Jyothi Prakash
     * Created Date -30-11-2021  
     */
	@Override
	public Address viewAllAddress(String id) throws AddressNotFoundException {
		Address add=add_repo.findByAddressId(id);
            if(add==null)
            	throw new AddressNotFoundException("Address NotFound ");
        return add;
	}

}
