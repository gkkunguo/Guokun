package com.example.helenkellercompute.guokun.design.MVC.Controller;

import com.example.helenkellercompute.guokun.R;
import com.example.helenkellercompute.guokun.design.MVC.Bean.Book;
import com.example.helenkellercompute.guokun.design.MVC.Model.BookModel;

import java.util.List;

/**
 * 作者：许英俊
 * 控制器层
 * 处理业务逻辑，调用模型层的操作，并对外暴露接口
 */
public class BookController {

    private BookModel mode;

    public BookController() {
        mode = new BookModel();
    }

    /**
     * 添加书本
     *
     * @param listener
     */
    public void add(onAddBookListener listener) {
        mode.addBook("JavaWeb从入门到精通", R.drawable.javaweb);
        if (listener != null) {
            listener.onComplete();
        }
    }

    /**
     * 删除书本
     *
     * @param listener
     */
    public void delete(onDeleteBookListener listener) {
        if (mode.query().isEmpty()) {
            return;
        } else {
            mode.deleteBook();
        }
        if (listener != null) {
            listener.onComplete();
        }
    }

    /**
     * 查询所有书本
     *
     * @return
     */
    public List<Book> query() {
        return mode.query();
    }

    /**
     * 添加成功的回调接口
     */
    public interface onAddBookListener {
        void onComplete();
    }

    /**
     * 删除成功的回调接口
     */
    public interface onDeleteBookListener {
        void onComplete();
    }
}
