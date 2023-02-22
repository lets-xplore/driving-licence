package com.fetcher.drivinglicence.repository;

import com.fetcher.drivinglicence.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {

    LoginModel findByEmailAndPassword(String email, String password);

}
