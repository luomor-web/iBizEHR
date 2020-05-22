import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmprofiles\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: getwflink");
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
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmprofiles\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: getwfstep");
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
mock.onPost(new RegExp(/^\/pcmprofiles\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/pcmprofiles\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/pcmprofiles\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});


// Select
mock.onGet(new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});
        
// JZBTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jzbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JZBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jzbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// SBJZB
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/sbjzb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: SBJZB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/sbjzb$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// JSPBTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// PrintSPB
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/printspb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: PrintSPB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/printspb$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// ClearPersonUpdateInfo
mock.onPut(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/clearpersonupdateinfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: ClearPersonUpdateInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/clearpersonupdateinfo$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// Invalid2
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/invalid2$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Invalid2");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/invalid2$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// BD
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/bd$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: BD");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/bd$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// JLDTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jldtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JLDTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jldtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// CheckYJSNF
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkyjsnf$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckYJSNF");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkyjsnf$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// GSSP
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/gssp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: GSSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/gssp$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// CheckEmail
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkemail$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckEmail");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkemail$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
        
// Update
mock.onPut(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// ReturnYPZ
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/returnypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: ReturnYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// CheckYglxIsChanged
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkyglxischanged$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckYglxIsChanged");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkyglxischanged$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// SX
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/sx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: SX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/sx$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// Invalid
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/invalid$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Invalid");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/invalid$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// JZBBTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jzbbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JZBBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jzbbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// ClearYPZ
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/clearypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: ClearYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/clearypz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// CheckFP
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkfp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckFP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkfp$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// SCBH
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/scbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: SCBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/scbh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
mock.onGet(new RegExp(/^\/pcmprofiles\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: GetDraft");
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
        
// ClearYYDJMC
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/clearyydjmc$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: ClearYYDJMC");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/clearyydjmc$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// Submit
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/submit$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Submit");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/submit$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// PersonUpdateInfo
mock.onPut(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/personupdateinfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: PersonUpdateInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/personupdateinfo$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// GSCS
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/gscs$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: GSCS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// FillingYPZ
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/fillingypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FillingYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/fillingypz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// YQWBD
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/yqwbd$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: YQWBD");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/yqwbd$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// USEYBH
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/useybh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: USEYBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/useybh$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// CheckMobieNumber
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/checkmobienumber$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: CheckMobieNumber");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/checkmobienumber$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// JLDBTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jldbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JLDBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jldbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// JSPTG
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/jsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: JSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
        
// SetNQDLDHTQX
mock.onPost(new RegExp(/^\/pcmprofiles\/?([a-zA-Z0-9\-\;]{0,35})\/setnqdldhtqx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: SetNQDLDHTQX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/setnqdldhtqx$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmprofileid'] == tempValue['pcmprofileid'] ){
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
    
// FetchYRDWSH_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchyrdwsh_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYRDWSH_CSRCYJ");
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

// FetchYRDWSH_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchyrdwsh_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYRDWSH_CSRCYJ");
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
    
// FetchJLDSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjldsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJLDSP");
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

// FetchJLDSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjldsp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJLDSP");
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
    
// FetchBD_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbd_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBD_CSRCYJ");
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

// FetchBD_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbd_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBD_CSRCYJ");
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
    
// FetchYPZSPB_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchypzspb_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYPZSPB_CSRCYJ");
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

// FetchYPZSPB_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchypzspb_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYPZSPB_CSRCYJ");
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
    
// FetchZPDWSH
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchzpdwsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchZPDWSH");
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

// FetchZPDWSH
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchzpdwsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchZPDWSH");
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
    
// FetchBD
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbd$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBD");
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

// FetchBD
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbd(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBD");
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
    
// FetchBHSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbhsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBHSP");
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

// FetchBHSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbhsp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBHSP");
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
    
// FetchLR
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchlr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchLR");
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

// FetchLR
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchlr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchLR");
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
    
// FetchRLSB
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrlsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRLSB");
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

// FetchRLSB
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrlsb(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRLSB");
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
    
// FetchFormType
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchformtype$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchFormType");
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

// FetchFormType
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchformtype(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchFormType");
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
    
// FetchHTRY_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchhtry_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchHTRY_CSRCYJ");
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

// FetchHTRY_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchhtry_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchHTRY_CSRCYJ");
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
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchDefault");
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
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchDefault");
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
    
// FetchJZBSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjzbsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJZBSP");
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

// FetchJZBSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjzbsp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJZBSP");
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
    
// FetchRZSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrzsp_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRZSP_CSRCYJ");
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

// FetchRZSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrzsp_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRZSP_CSRCYJ");
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
    
// FetchJLDSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjldsp_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJLDSP_CSRCYJ");
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

// FetchJLDSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjldsp_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJLDSP_CSRCYJ");
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
    
// FetchBHSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbhsp_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBHSP_CSRCYJ");
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

// FetchBHSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchbhsp_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchBHSP_CSRCYJ");
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
    
// FetchLR_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchlr_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchLR_CSRCYJ");
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

// FetchLR_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchlr_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchLR_CSRCYJ");
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
    
// FetchYPZBB_READ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchypzbb_read$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYPZBB_READ");
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

// FetchYPZBB_READ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchypzbb_read(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYPZBB_READ");
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
    
// FetchHTRY
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchhtry$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchHTRY");
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

// FetchHTRY
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchhtry(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchHTRY");
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
    
// FetchRZSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrzsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRZSP");
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

// FetchRZSP
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrzsp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRZSP");
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
    
// FetchYRDWCS_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchyrdwcs_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYRDWCS_CSRCYJ");
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

// FetchYRDWCS_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchyrdwcs_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchYRDWCS_CSRCYJ");
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
    
// FetchJZBSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjzbsp_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJZBSP_CSRCYJ");
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

// FetchJZBSP_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchjzbsp_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchJZBSP_CSRCYJ");
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
    
// FetchRLSB_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrlsb_csrcyj$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRLSB_CSRCYJ");
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

// FetchRLSB_CSRCYJ
mock.onGet(new RegExp(/^\/pcmprofiles\/fetchrlsb_csrcyj(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: FetchRLSB_CSRCYJ");
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


// GetYPZNL
mock.onGet(new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/getypznl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: GetYPZNL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/getypznl$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// GetPcmprofileInfo
mock.onGet(new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/getpcmprofileinfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: GetPcmprofileInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})\/getpcmprofileinfo$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmprofile 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmprofileid'];
    const matchArray:any = new RegExp(/^\/pcmprofiles\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmprofileid, tempValue.pcmprofileid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
