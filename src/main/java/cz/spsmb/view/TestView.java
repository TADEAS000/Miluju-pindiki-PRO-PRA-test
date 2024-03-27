package cz.spsmb.view;

import cz.spsmb.dao.CarRepository;
import cz.spsmb.dao.GarageRepository;
import cz.spsmb.dto.CarDTO;
import cz.spsmb.dto.GarageDTO;
import cz.spsmb.dto.PersonDTO;
import cz.spsmb.model.Car;
import cz.spsmb.model.Garage;
import cz.spsmb.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import cz.spsmb.dao.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class TestView {

    @Inject
    PersonRepository personRepository;

    @Inject
    GarageRepository garageRepository;

    @Inject
    CarRepository carRepository;

    List<Person> personList;
    List<Garage> garageList;
    List<Car> carList;
    String name;
    int age;

    PersonDTO newPerson;
    GarageDTO newGarage;
    CarDTO newCar;

    String selectedPersonGarage;
    String selectedCar;


    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        String personName = params.get("name");

        System.out.println(personName);

        personList = personRepository.listAll();
        System.out.println(personList);

        personList = personRepository.listAll();
        carList = carRepository.listAll();
        garageList = garageRepository.listAll();

        newPerson = new PersonDTO();
        newGarage = new GarageDTO();
        newCar = new CarDTO();

    }

    public GarageDTO getNewGarage() {
        return newGarage;
    }

    public String getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(String selectedCar) {
        this.selectedCar = selectedCar;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Garage> getGarageList() {
        return garageList;
    }

    public void setGarageList(List<Garage> catList) {
        this.garageList = catList;
    }

    public String getSelectedPersonGarage() {
        return selectedPersonGarage;
    }

    public void setSelectedPersonGarage(String selectedPersonGarage) {
        this.selectedPersonGarage = selectedPersonGarage;
    }

    public CarDTO getNewCar() {
        return newCar;
    }

    public void setNewCar(CarDTO newCar) {
        this.newCar = newCar;
    }

    public GarageRepository getGarageRepository() {
        return garageRepository;
    }

    public void setGarageRepository(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public GarageDTO getNewCat() {
        return newGarage;
    }

    public void setNewGarage(GarageDTO newGarage) {
        this.newGarage = newGarage;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(PersonDTO newPerson) {
        this.newPerson = newPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<String> getPersonNames() {
        return personList.stream().map(person -> person.getName()).collect(Collectors.toList());
    }

    public List<String> getCarNames(){
        return carList.stream().map(car -> car.getBrand()).collect(Collectors.toList());
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Transactional
    public void savePerson(){

        System.out.println("SavePerson");
        if(validateInputPerson(newPerson)){
            Person person = new Person();
            person.setName(newPerson.getName());
            person.setAge(newPerson.getAge());

            person.setCar(carRepository.listByName(selectedCar));

            personRepository.persist(person);
            personList = personRepository.listAll();
        }
    }

    private boolean validateInputPerson(PersonDTO personDTO){
        return !(personDTO.getName().isEmpty() || personDTO.getAge() == 0 || selectedCar.isEmpty());
    }

    @Transactional
    public void saveGarage(){
        System.out.println("SaveGarage");
        if(validateInputCat(newGarage)){
            Garage garage = new Garage();
            garage.setUlice(newGarage.getUlice());
            garage.setCisloPopisne(newGarage.getCisloPopisne());
            Optional<Person> personOptional = personRepository.listByName(selectedPersonGarage);
            garage.setPerson(personOptional.get());

            garageRepository.persist(garage);
            garageList = garageRepository.listAll();
        }
    }

    private boolean validateInputCat(GarageDTO garageDTO){
        return !(garageDTO.getUlice().isEmpty() || garageDTO.getCisloPopisne() == 0);
    }

    @Transactional
    public void saveCar(){
        System.out.println("SaveCaR");
        if(validateInputCar(newCar)){
            Car car = new Car();
            car.setBrand(newCar.getBrand());
            car.setModel(newCar.getModel());
            car.setYearOfManufacture(newCar.getYearOfManufacture());
            car.setPrice(newCar.getPrice());

            carRepository.persist(car);
            carList = carRepository.listAll();
        }
    }

    private boolean validateInputCar(CarDTO carDTO){
        return !(carDTO.getBrand().isEmpty() || carDTO.getModel().isEmpty() || carDTO.getPrice() == 0 || carDTO.getYearOfManufacture() == 0);
    }
}