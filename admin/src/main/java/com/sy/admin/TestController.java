package com.sy.admin;

import com.sy.sycommon.Test;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api("测试")
public class TestController {

    @ApiOperation(value = "计算+", notes = "加法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", paramType = "path", value = "数字a", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "b", paramType = "path", value = "数字b", required = true, dataType = "Long")
    })
    @GetMapping("/{a}/{b}")
    public Integer get(@PathVariable Integer a, @PathVariable Integer b) {
        return a + b;
    }
    @ApiOperation(value = "计算-", notes = "减法")
    @PostMapping ("/{c}/{d}")
    public Integer set(@ApiParam(name = "c", value = "数字c", required = true)  @PathVariable Integer c,
                       @ApiParam(name = "d", value = "数字b", required = true)   @PathVariable Integer d) {
        return c - d;
    }

    @ApiOperation(value="添加Test", notes="增加Test" )
    @ApiImplicitParam(name = "Test", value = "Test信息", required = true, dataType = "Test")
    @PutMapping("/save")
    public Test save(@RequestBody Test test) {

        return test;
    }


}
