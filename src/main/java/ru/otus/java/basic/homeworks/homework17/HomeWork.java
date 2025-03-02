package ru.otus.java.basic.homeworks.homework17;

public class HomeWork {
    public static void main(String[] args) {
        final String NAME1 = "Иванов Иван Иванович";
        final String NAME2 = "Петров Петр Петрович";
        final String NAME3 = "Сидоров Сидор Сидорович";
        final String NAME4 = "Сергеев Сергей Сергеевич";
        final String NAME5 = "Антонов Антон Антонович";
        final String NAME123 = "Архипов Архип Архипович";
        
        final String PHONE11 = "111-11-11";
        final String PHONE12 = "112-12-12";
        final String PHONE13 = "113-13-13";
        final String PHONE14 = "114-14-14";
        final String PHONE15 = "115-15-15";
        final String PHONE21 = "221-21-21";
        final String PHONE22 = "222-22-22";
        final String PHONE31 = "331-31-31";
        final String PHONE32 = "332-32-32";
        final String PHONE33 = "333-33-33";
        final String PHONE41 = "441-41-41";
        final String PHONE42 = "442-42-42";
        final String PHONE43 = "443-43-43";
        final String PHONE51 = "551-51-51";
        final String PHONE52 = "552-52-52";
        final String PHONE53 = "553-53-53";
        final String PHONE54 = "554-54-54";
        final String PHONE123 = "111-22-33";
        
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(NAME1, PHONE11);
        phoneBook.add(NAME1, PHONE12);
        phoneBook.add(NAME1, PHONE13);
        phoneBook.add(NAME1, PHONE14);
        phoneBook.add(NAME1, PHONE15);

        phoneBook.add(NAME2, PHONE21);
        phoneBook.add(NAME2, PHONE22);
        phoneBook.add(NAME2, PHONE22);

        phoneBook.add(NAME3, PHONE31);
        phoneBook.add(NAME3, PHONE32);
        phoneBook.add(NAME3, PHONE33);

        phoneBook.add(NAME4, PHONE41);
        phoneBook.add(NAME4, PHONE42);
        phoneBook.add(NAME4, PHONE43);

        phoneBook.add(NAME5, PHONE51);
        phoneBook.add(NAME5, PHONE52);
        phoneBook.add(NAME5, PHONE53);
        phoneBook.add(NAME5, PHONE54);

        System.out.println(phoneBook.findWithMsg(NAME1));
        System.out.println(phoneBook.findWithMsg(NAME3));
        System.out.println(phoneBook.findWithMsg(NAME4));
        System.out.println(phoneBook.findWithMsg(NAME123));

        System.out.println(phoneBook.containsPhoneNumberWithMsg(PHONE33));
        System.out.println(phoneBook.containsPhoneNumberWithMsg(PHONE54));
        System.out.println(phoneBook.containsPhoneNumberWithMsg(PHONE123));
    }
}
