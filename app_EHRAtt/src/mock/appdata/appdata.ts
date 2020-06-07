import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs';

// 获取应用数据
mock.onGet('/appdata').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,{
        context:{
             // 用户标识
         srfuserid:'5ffafc68-eccd-a5be-0bce-40215334cee3',
         // 用户名称
         srfusername:'xignzi006',
         // 用户图像路径
         srfusericonpath:null,
         // 当前的用户模式
         srfusermode:'default',
         // 登录名称
         srfloginname:'xignzi006',
         // 本地化（Spring变量）
         srflocale:'zh',
         // 当前用户时区标识
         srftimezone:'Asia/Shanghai',
         // 当前用户组织标识
         srforgid:"a1494aa93f1d1226f7aae63db6f15aa5",
         //当前用户组织名称
         srforgname:"上海公司",
         // 当前用户组织部门标识
         srforgsectorid:"5bd1ecf4d3c31e31cb66373df56b852f",
         // 当前用户组织部门名称
         srforgsectorname:"项目一部",
          // 当前用户条线代码
         srfsectorbc:""
        },
         //当前用户所有组织部门标识
         srforgsections:[{"srforgsectorid":"5bd1ecf4d3c31e31cb66373df56b852f","srforgsectorname":"项目一部"},{"srforgsectorid":"2ad1ecf4d3c31e31cb66373df56b852f","srforgsectorname":"项目二部"}]
     }];
});

