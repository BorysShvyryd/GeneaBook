package com.borman.geneobook.waste;

import com.borman.geneobook.entity.Role;
import com.borman.geneobook.repository.RoleRepository;
import com.borman.geneobook.service.RoleService;

import java.util.UUID;

public class test {
    public static void main(String args[]) throws Exception{

//        System.out.println(UUID.randomUUID());

        // InitROLE

        RoleRepository roleRepository = null;

        Role role = new Role();

        role.setId(1L);
        role.setName("ADMIN");
        roleRepository.save(role);

        role.setId(1L);
        role.setName("USER");
        roleRepository.save(role);


//        //Creating a KeyGenerator object
//        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
//
//        //Creating a SecureRandom object
//        SecureRandom secRandom = new SecureRandom();
//
//        //Initializing the KeyGenerator
//        keyGen.init(secRandom);
//
//        //Creating/Generating a key
//        Key key = keyGen.generateKey();
//
//        System.out.println("key:"+key);
//        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//        cipher.init(cipher.ENCRYPT_MODE, key);
//
//        String msg = new String("Hi how are you");
//        byte[] bytes = cipher.doFinal(msg.getBytes());
//        System.out.println(bytes);

//        String token = CreateRandomToken.getToken("token");
        
//            //Creating KeyPair generator object
//            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
//
//            //Initializing the KeyPairGenerator
//            keyPairGen.initialize(2048);
//
//            //Generating the pair of keys
//            KeyPair pair = keyPairGen.generateKeyPair();
//
//            //Getting the private key from the key pair
//            PrivateKey privKey = pair.getPrivate();
//
//            //Getting the public key from the key pair
//            PublicKey publicKey = pair.getPublic();
//            System.out.println("Keys generated:" + publicKey);
        
//        }

    }
}
