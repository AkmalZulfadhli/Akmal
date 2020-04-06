package sportsApp.data;

import org.springframework.data.repository.CrudRepository;

import sportsApp.model.Registration;

public interface SportsRepository extends CrudRepository<Registration, Integer>{

}
