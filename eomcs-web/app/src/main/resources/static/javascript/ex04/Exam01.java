class Exam01 {

    public static void main(String[] args){
        System.out.println("Hello!");
        
        //설계도
        class Student {
            String name;
            int age;
            boolean working;
        }
        
        //설계도에 따라 객체생성(메모리 준비)
        Student obj = new Student();
        //객체 프로퍼티에 값 저장
        obj.name = "hong gildong";
        obj.age = 20;
        obj.working = true;
        obj.tel = "1111-1111";

        // 객체 프로퍼티에 저장된 값 꺼내기
        System.out.println(obj.name);
        System.out.println(obj.age);
        System.out.println(obj.working);
        System.out.println(obj.tel);

    }
}