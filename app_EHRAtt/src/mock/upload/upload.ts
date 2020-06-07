import Mock from 'mockjs'
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();
const Random = Mock.Random;

// ajax上传
Mock.mock(RegExp(new RegExp(/^\.\.\/ibizutil\/upload.*$/)),"post",(ops:any) => { // 拦截ajax请求，调用函数
    console.log(ops) // 先看一下这个ops是什么
    console.log(ops.body)
    return {
        "filename": "xxx.png",
        "fileid": Random.string("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",32)
    };
});

// axios上传
mock.onPost(new RegExp(/^\.\.\/ibizutil\/upload.*$/)).reply((config: any) => {
  return [200, {
    "filename": "xxx.png",
    "fileid": Random.string("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",32)
  }];
});