package com.nc.condition;

public class LinuxCmd implements ShowCmd {
    @Override
    public String showCmd() {

        return "ls";
    }
}
