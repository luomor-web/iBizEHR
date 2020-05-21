import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmbdsqdmxes\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: getwflink");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status,[
        {"sequenceFlowId":"dfdsfdsfdsfdsfds","sequenceFlowName":"同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddlfldldfldsfds","refViewKey":""},
        {"sequenceFlowId":"ddssdfdfdfdfsfdf","sequenceFlowName":"不同意",
         "taskId":"aaaaddddccccddddd","processDefinitionKey":"support-workorders-approve-v1",
         "processInstanceId":"ddfdsldlfdlldsf","refViewKey":"workorder_ltform_editview"}
        ]];
});

// getwfstep
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmbdsqdmxes\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: getwfstep");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, [
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-dfdfd",
        "userTaskName":"待审",
        "cnt":0,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"
        },
        {"userTaskId":"sddfddfd-dfdf-fdfd-fdf-87927",
        "userTaskName":"待分配",
        "cnt":3,
        "processDefinitionKey":"support-workorders-approve-v1",
        "processDefinitionName":"工单审批流程v1"}
        ]];
});

// createBatch
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/pcmbdsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/pcmbdsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});


// Select
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});
        
// ZJJSDMB
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/zjjsdmb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: ZJJSDMB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zjjsdmb$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// CQBXCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/cqbxcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: CQBXCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/cqbxcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// SXJSDMB
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/sxjsdmb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SXJSDMB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sxjsdmb$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// PDZJ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/pdzj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: PDZJ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/pdzj$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// SXJSDMB2
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/sxjsdmb2$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SXJSDMB2");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sxjsdmb2$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// Create
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas[0]);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas[0]];
});
        
// ZZSQ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/zzsq$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: ZZSQ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// SXDMB
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/sxdmb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SXDMB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sxdmb$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// DGCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/dgcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: DGCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/dgcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// SetPersonInfo
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/setpersoninfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SetPersonInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/setpersoninfo$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// GZCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/gzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: GZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/gzcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// JPCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jpcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: JPCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jpcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// Save
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// LZCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/lzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: LZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/lzcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// NTCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/ntcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: NTCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ntcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// Update
mock.onPut(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});

// GetDraft
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: GetDraft");
    console.table({url:config.url, method: config.method, data:config.data});
    // GetDraft
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// SHBTG
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/shbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// ZJBDCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/zjbdcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: ZJBDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zjbdcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// CheckKey
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// TXCZ
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/txcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: TXCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/txcz$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// JZJJSDMB
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jzjjsdmb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: JZJJSDMB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzjjsdmb$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
        
// SHTG
mock.onPost(new RegExp(/^\/pcmbdsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/shtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: SHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    //let items = mockDatas ? mockDatas : [];
    //let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmbdsqdmxid'] == tempValue['pcmbdsqdmxid'] ){
            for(let value in data){
              if(item.hasOwnProperty(value)){
                  item[value] = data[value];
              }
            }
        }
    })
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(data);
    console.groupEnd();
    console.groupEnd();
    return [status, data];
});
    
// FetchJPSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchjpsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchJPSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchJPSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchjpsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchJPSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchNTSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchntsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchNTSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchNTSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchntsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchNTSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchNTSQMXGR
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchntsqmxgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchNTSQMXGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchNTSQMXGR
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchntsqmxgr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchNTSQMXGR");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchTXSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchtxsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchTXSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchTXSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchtxsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchTXSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchGZSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchgzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchGZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchGZSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchgzsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchGZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchZJBDSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchzjbdsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchZJBDSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchZJBDSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchzjbdsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchZJBDSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchDGSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchdgsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchDGSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchDGSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchdgsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchDGSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchCQBXSQMXDS
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchcqbxsqmxds$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchCQBXSQMXDS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchCQBXSQMXDS
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchcqbxsqmxds(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchCQBXSQMXDS");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchLZSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchlzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchLZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchLZSQMX
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchlzsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchLZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchLZSQMXGR
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchlzsqmxgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchLZSQMXGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchLZSQMXGR
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchlzsqmxgr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchLZSQMXGR");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
    
// FetchDefault
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(mockDatas);
    console.groupEnd();
    console.groupEnd();
    return [status, mockDatas ? mockDatas : []];
});

// FetchDefault
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    if(config.url.includes('page')){
        let url = config.url.split('?')[1];
        let params  =  qs.parse(url);
        Object.assign(config, params);
    }
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    let total = mockDatas.length;
    let records: Array<any> = [];
    if(!config.page || !config.size){
        records = mockDatas;
    }else{
        if((config.page-1)*config.size < total){
          records = mockDatas.slice(config.page,config.size);
        }
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(records ?  records : []);
    console.groupEnd();
    console.groupEnd();
    return [status, records ?  records : []];
});
// URI参数传递情况未实现
// URI参数传递情况未实现
// URI参数传递情况未实现
// URI参数传递情况未实现
// URI参数传递情况未实现
// URI参数传递情况未实现
// URI参数传递情况未实现


// Get
mock.onGet(new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmbdsqdmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmbdsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmbdsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
    let tempValue: any = {};
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    let _items = items.find((item: any) => Object.is(item.pcmbdsqdmxid, tempValue.pcmbdsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
