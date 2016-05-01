from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Firefox()
driver.get("http://localhost:8080/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient")

username = driver.find_element_by_id("username")
username.send_keys('admin')
password = driver.find_element_by_id("password")
password.send_keys('Admin123')

driver.find_element_by_id('Inpatient Ward').click()
driver.find_element_by_id('login-button').click()
driver.find_element_by_id('referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension').click()

name = driver.find_element_by_name("givenName")
name.send_keys("Shreyans")

driver.find_element_by_name("familyName").send_keys("Sheth")

driver.find_element_by_id('genderLabel').click()
driver.find_element_by_id('gender-field').click()

driver.find_element_by_id('birthdateLabel').click()

day = driver.find_element_by_id('birthdateDay-field')
day.send_keys('17')

driver.find_element_by_id('birthdateMonth-field').click()
driver.find_element_by_xpath("//select[@id='birthdateMonth-field']/option[text()='June']").click()

year = driver.find_element_by_id('birthdateYear-field').send_keys('1996')

address = driver.find_element_by_id('null').click()

driver.find_element_by_id('address1').send_keys('Pune')
driver.find_element_by_id('phoneNumberLabel').click()
driver.find_element_by_id('confirmation_label').click()

driver.find_element_by_id('submit').click()