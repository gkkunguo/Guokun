// ISecurityCenter.aidl
package com.example.helenkellercompute.guokun;

// Declare any non-default types here with import statements

interface ISecurityCenter {
    String encrypt(String content);
    String decrypt(String password);
}