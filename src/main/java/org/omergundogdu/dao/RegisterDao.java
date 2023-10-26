package org.omergundogdu.dao;

import org.omergundogdu.dto.RegisterDto;

import java.util.ArrayList;

// for Database & Java Core
public class RegisterDao  implements IDaoGenerics<RegisterDto> {

    // SPEED DATA
    @Override
    public String speedData(Long id) {
        return null;
    }

    // ALL DELETE
    @Override
    public String allDelete() {
        return null;
    }

    // CREATE
    @Override
    public void create(RegisterDto registerDto) {

    }

    // FIND BY ID
    @Override
    public RegisterDto findById(Long id) {
        return null;
    }

    // LIST
    @Override
    public ArrayList<RegisterDto> list() {
        return null;
    }

    // UPDATE
    @Override
    public RegisterDto update(Long id, RegisterDto registerDto) {
        return null;
    }

    // DELETE
    @Override
    public RegisterDto delete(Long id) {
        return null;
    }
}