/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.tdtrung.mathutil.core;

import static com.tdtrung.mathutil.core.MathUtil.*;
// import static là dành riêng cho những hàm static
// gọi hàm bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author ASUS
 */
public class MathUtilTest {
    
    // chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    // vào trong câu lênh kiểm thử
    
    // chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
                                {1, 1},
                                {2, 2},
                                {5, 120},
                                {6, 720}
                            };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") // tên hàm cung cấp data, ngầm định thứ tự
    // của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnWell(){
//        assertEquals(120, getFactorial(5));
//    }
    
    // Bắt ngoại lệ khi đưa data cà chớn!!
//    @Test(expected = tên ngoại lệ.class) Junit 4 hoi, Junit 5 ko làm vậy
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException(){
        // xài biểu thức Lambda
        // hàm nhận tham số thứ 22 là 1 cái object/có code implement cái
        // functional interface tên là Executable - có 1 hàm duy nhất ko code
        // tên là execute()
        // chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

//        Executable exObject = () -> getFactorial(-5);
                
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5) );
    }
    
}
