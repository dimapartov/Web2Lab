/*
package com.example.websecondlab.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.websecondlab.consts.enums.CategoryEnum;
import com.example.websecondlab.consts.enums.EngineTypeEnum;
import com.example.websecondlab.consts.enums.RoleEnum;
import com.example.websecondlab.consts.enums.TransmissionTypeEnum;
import com.example.websecondlab.services.BrandService;
import com.example.websecondlab.services.ModelService;
import com.example.websecondlab.services.OfferService;
import com.example.websecondlab.services.RoleService;
import com.example.websecondlab.services.UserService;
import com.example.websecondlab.services.dtos.BrandDTO;
import com.example.websecondlab.services.dtos.ModelDTO;
import com.example.websecondlab.services.dtos.OfferDTO;
import com.example.websecondlab.services.dtos.RoleDTO;
import com.example.websecondlab.services.dtos.UserDTO;
import com.github.javafaker.Faker;

@Component
public class DataInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final RoleService roleService;
    private final UserService userService;


    @Autowired
    public DataInit(BrandService brandService, ModelService modelService, OfferService offerService, RoleService roleService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.roleService = roleService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }


    private void seedData() throws Exception {
        Faker faker = new Faker();
        Random random = new Random();
//----------------------------------------------------------------------------------------------------------------------
//        roles generation

        RoleDTO userRoleDTO = new RoleDTO(RoleEnum.USER);
        RoleDTO adminRoleDTO = new RoleDTO(RoleEnum.ADMIN);
        roleService.addRole(userRoleDTO);
        roleService.addRole(adminRoleDTO);
        List<RoleDTO> roles = roleService.getAllRoles();

//----------------------------------------------------------------------------------------------------------------------
//        users generation

        for (int i = 0; i < 5; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(faker.name().username());
            userDTO.setActive(random.nextBoolean());
            userDTO.setImageUrl(faker.internet().url());
            userDTO.setRole(roles.get(random.nextInt(roles.size())));
            userDTO.setPassword(faker.internet().password());
            userDTO.setFirstName(faker.name().firstName());
            userDTO.setLastName(faker.name().lastName());
            userService.addUser(userDTO);
        }
        List<UserDTO> users = userService.getUsersByRole("user");
        List<UserDTO> admins = userService.getUsersByRole("admin");

//----------------------------------------------------------------------------------------------------------------------
//        cars generation

        String[] brands = {"Audi", "Toyota", "BMW", "Mercedes", "Dodge"};
        for (String brand : brands) {
            BrandDTO brandDTO = new BrandDTO(brand);
            BrandDTO carBrand = brandService.addBrand(brandDTO);
            switch (brand) {
                case ("Audi"):
                    ModelDTO modelDTO = new ModelDTO("Q1", CategoryEnum.CAR, faker.internet().url(), 2005, 2023, carBrand);
                    ModelDTO modelDTO1 = new ModelDTO("Q2", CategoryEnum.CAR, faker.internet().url(), 2006, 2023, carBrand);
                    modelService.addModel(modelDTO);
                    modelService.addModel(modelDTO1);
                    break;
                case ("Toyota"):
                    ModelDTO modelDTO2 = new ModelDTO("Mark2", CategoryEnum.CAR, faker.internet().url(), 1968, 2004, carBrand);
                    ModelDTO modelDTO3 = new ModelDTO("Soarer", CategoryEnum.CAR, faker.internet().url(), 1981, 2005, carBrand);
                    ModelDTO modelDTO4 = new ModelDTO("Chaser", CategoryEnum.CAR, faker.internet().url(), 1977, 2001, carBrand);
                    ModelDTO modelDTO5 = new ModelDTO("Cresta", CategoryEnum.CAR, faker.internet().url(), 1980, 2001, carBrand);
                    modelService.addModel(modelDTO2);
                    modelService.addModel(modelDTO3);
                    modelService.addModel(modelDTO4);
                    modelService.addModel(modelDTO5);
                    break;
                case ("BMW"):
                    ModelDTO modelDTO6 = new ModelDTO("M2", CategoryEnum.CAR, faker.internet().url(), 1990, 2023, carBrand);
                    ModelDTO modelDTO7 = new ModelDTO("M3", CategoryEnum.CAR, faker.internet().url(), 1991, 2023, carBrand);
                    modelService.addModel(modelDTO6);
                    modelService.addModel(modelDTO7);

                    break;
                case ("Mercedes"):
                    ModelDTO modelDTO8 = new ModelDTO("E", CategoryEnum.CAR, faker.internet().url(), 2000, 2023, carBrand);
                    ModelDTO modelDTO9 = new ModelDTO("C", CategoryEnum.CAR, faker.internet().url(), 2000, 2023, carBrand);
                    modelService.addModel(modelDTO8);
                    modelService.addModel(modelDTO9);
                    break;
                case ("Dodge"):
                    ModelDTO modelDTO10 = new ModelDTO("Charger", CategoryEnum.CAR, faker.internet().url(), 1966, 2023, carBrand);
                    ModelDTO modelDTO11 = new ModelDTO("Challenger", CategoryEnum.CAR, faker.internet().url(), 1970, 2023, carBrand);
                    ModelDTO modelDTO12 = new ModelDTO("RAM", CategoryEnum.TRUCK, faker.internet().url(), 1994, 2002, carBrand);
                    ModelDTO modelDTO13 = new ModelDTO("Viper", CategoryEnum.CAR, faker.internet().url(), 1992, 2017, carBrand);
                    ModelDTO modelDTO14 = new ModelDTO("Coronet", CategoryEnum.CAR, faker.internet().url(), 1949, 1976, carBrand);
                    modelService.addModel(modelDTO10);
                    modelService.addModel(modelDTO11);
                    modelService.addModel(modelDTO12);
                    modelService.addModel(modelDTO13);
                    modelService.addModel(modelDTO14);
                    break;
            }
        }
        List<ModelDTO> models = modelService.getAllModels();
        List<ModelDTO> modelsByBrand = modelService.getModelsByBrand("Dodge");
        List<ModelDTO> modelsByCategory = modelService.getModelsByCategory("truck");

//----------------------------------------------------------------------------------------------------------------------
//        offers generation

        EngineTypeEnum[] engineTypeValues = EngineTypeEnum.values();
        TransmissionTypeEnum[] transmissionTypeValues = TransmissionTypeEnum.values();
        for (int i = 0; i < 100; i++) {
            OfferDTO offerDTO = new OfferDTO();
            offerDTO.setDescription(faker.lorem().sentence());
            offerDTO.setEngineType(engineTypeValues[random.nextInt(engineTypeValues.length)]);
            offerDTO.setMileage(random.nextInt());
            offerDTO.setModel(models.get(random.nextInt(models.size())));
            offerDTO.setPrice(BigDecimal.valueOf(random.nextInt(50_000, 10_000_000)));
            offerDTO.setSeller(users.get(random.nextInt(users.size())));
            offerDTO.setYear(random.nextInt(1949, 2023));
            offerDTO.setImageUrl(faker.internet().url());
            offerDTO.setTransmissionType(transmissionTypeValues[random.nextInt(transmissionTypeValues.length)]);
            offerService.addOffer(offerDTO);
        }
        List<OfferDTO> offersByEngineType = offerService.getOffersByEngineType("gasoline");
        List<OfferDTO> offersByMileageLowerThan = offerService.getOffersByMileageLowerThan(500_000);
        List<OfferDTO> offersByTransmissionType = offerService.getOffersByTransmissionType("manual");
        List<OfferDTO> offersByPriceLowerThan = offerService.getOffersByPriceLowerThan(BigDecimal.valueOf(500_000));

//----------------------------------------------------------------------------------------------------------------------
//        print demonstration

        System.out.println("---------- Roles: ----------");
        for (RoleDTO role : roles) {
            System.out.println(role);
        }
        System.out.println("---------- Users: ----------");
        for (UserDTO user : users) {
            System.out.println(user);
        }
        System.out.println("---------- Admins: ----------");
        for (UserDTO admin : admins) {
            System.out.println(admin);
        }
        System.out.println("---------- Models: ----------");
        for (ModelDTO model : models) {
            System.out.println(model);
        }
        System.out.println("---------- Models by brand name: ----------");
        for (ModelDTO model : modelsByBrand) {
            System.out.println(model);
        }
        System.out.println("---------- Models by category: ----------");
        for (ModelDTO model : modelsByCategory) {
            System.out.println(model);
        }
        System.out.println("---------- Offers by mileage lower than: ----------");
        for (OfferDTO offer : offersByMileageLowerThan) {
            System.out.println(offer);
        }
        System.out.println("---------- Offers by engine type: ----------");
        for (OfferDTO offer : offersByEngineType) {
            System.out.println(offer);
        }
        System.out.println("---------- Offers by transmission type: ----------");
        for (OfferDTO offer : offersByTransmissionType) {
            System.out.println(offer);
        }
        System.out.println("---------- Offers by price lower than: ----------");
        for (OfferDTO offer : offersByPriceLowerThan) {
            System.out.println(offer);
        }
    }
}*/