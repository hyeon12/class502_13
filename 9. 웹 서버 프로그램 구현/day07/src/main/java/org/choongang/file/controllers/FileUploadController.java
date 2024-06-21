package org.choongang.file.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletDiskFileUpload;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@WebServlet("/file/upload")
public class FileUploadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //조회
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/file/upload.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //처리
        JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload();

        //multipart 형식 body 데이터를 일반 양식과 파일 데이터로 분리해서 조회가능한 List 형태로 변환
        List<DiskFileItem> items = upload.parseRequest(req);
        for(DiskFileItem item : items){

            if(item.isFormField()){
                //isFormField() : 일반 데이터 양식이면 true 반환
                //일반 텍스트 형태의 양식 데이터(subject, content)
                String name = item.getFieldName();
                String value = item.getString(Charset.forName("UTF-8"));
                System.out.printf("name=%s, value=%s%n", name, value);
            }else{
                //파일 데이터(file)
                String fileName = item.getName(); // 파일 이름
                String contentType = item.getContentType(); // 파일 형식
                long size = item.getSize(); // 파일 용량

                System.out.printf("파일이름 : %s, 파일형식 : %s, 파일용량 : %d%n", fileName, contentType, size);

                File file = new File("D:/uploads/" + fileName);
                item.write(file.toPath()); //메모리에 있는 파일 데이터가 file 쪽 경로로 이동
            }
        }
    }
}
