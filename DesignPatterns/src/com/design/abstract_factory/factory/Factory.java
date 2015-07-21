package com.design.abstract_factory.factory;

import com.design.abstract_factory.base.People;

public interface Factory {
	public People createBlack();  
	  
    public People createYellow();  
  
    public People createWhite();  
}
