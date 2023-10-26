package org.omergundogdu.controller;

import org.omergundogdu.dao.IDaoGenerics;
import org.omergundogdu.dto.RegisterDto;

import java.util.ArrayList;

public class RegisterController  implements IDaoGenerics<RegisterDto> {

    // Injection

    @Override
    public String speedData(Long id) {
        return null;
    }

    @Override
    public String allDelete() {
        return null;
    }

    @Override
    public void create(RegisterDto registerDto) {

    }

    @Override
    public RegisterDto findById(Long id) {
        return null;
    }

    @Override
    public ArrayList<RegisterDto> list() {
        return null;
    }

    @Override
    public RegisterDto update(Long id, RegisterDto registerDto) {
        return null;
    }

    @Override
    public RegisterDto delete(RegisterDto registerDto) {
        return null;
    }
}
