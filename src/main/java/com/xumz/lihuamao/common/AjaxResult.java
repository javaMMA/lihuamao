package com.xumz.lihuamao.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xumingzhe
 * @date 2022/3/17 21:19
 * @description:
 */
@Data
@AllArgsConstructor
public class AjaxResult<T> {

    String msg;

    T data;


}
