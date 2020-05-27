import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pimbyzzjlmxes\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: getwflink");
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
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pimbyzzjlmxes\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: getwfstep");
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
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/pimbyzzjlmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/pimbyzzjlmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});



// Select
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

// Select
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

    
// SHTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// SHTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// SHTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/shtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ReturnYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// ReturnYPZ
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ReturnYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// ReturnYPZ
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/returnypz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ReturnYPZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/returnypz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JSPTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JSPTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jsptg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jsptg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// FillPersonInfo
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/fillpersoninfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FillPersonInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/fillpersoninfo$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// FillPersonInfo
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/fillpersoninfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FillPersonInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/fillpersoninfo$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// FillPersonInfo
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/fillpersoninfo$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FillPersonInfo");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/fillpersoninfo$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GetDraft");
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


// GetDraft
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GetDraft");
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

// GetDraft
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GetDraft");
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

    
// JSHTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JSHTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JSHTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jshtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// JSHBTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JSHBTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JSHBTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jshbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jshbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// Ensure
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Ensure");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Ensure
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Ensure");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Ensure
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/ensure$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Ensure");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/ensure$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// SHBTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// SHBTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// SHBTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/shbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: SHBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/shbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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



    
// GSDSZSP
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszsp$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// GSDSZSP
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszsp$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// GSDSZSP
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/gsdszsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszsp$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// ZZCZ
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ZZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzcz$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// ZZCZ
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ZZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzcz$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// ZZCZ
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/zzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: ZZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzcz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// DSB
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/dsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: DSB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/dsb$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// DSB
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/dsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: DSB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/dsb$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// DSB
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/dsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: DSB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/dsb$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPut(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Update
mock.onPut(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Update
mock.onPut(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Create
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Create
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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

    
// JZBSHQR
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbshqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSHQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbshqr$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JZBSHQR
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbshqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSHQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbshqr$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JZBSHQR
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jzbshqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSHQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbshqr$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// GSDSZSPBTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszspbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// GSDSZSPBTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszspbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// GSDSZSPBTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/gsdszspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSDSZSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gsdszspbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// GSCSBTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscsbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCSBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscsbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// GSCSBTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscsbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCSBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscsbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// GSCSBTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/gscsbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCSBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscsbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JSPBTG
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JSPBTG
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jspbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JSPBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jspbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// Save
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// Save
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// GSCS
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// GSCS
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/gscs$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: GSCS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/gscs$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// CheckKey
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// CheckKey
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// UpdatePeopleNum
mock.onPut(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/updatepeoplenum$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: UpdatePeopleNum");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/updatepeoplenum$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// UpdatePeopleNum
mock.onPut(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/updatepeoplenum$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: UpdatePeopleNum");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/updatepeoplenum$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// UpdatePeopleNum
mock.onPut(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/updatepeoplenum$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: UpdatePeopleNum");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/updatepeoplenum$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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

    
// JZBSPQR
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbspqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSPQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbspqr$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});

    
// JZBSPQR
mock.onPost(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbspqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSPQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbspqr$/).exec(config.url);
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
    console.table({});
    console.groupEnd();
    console.groupEnd();
    return [status, {}];
});
        
// JZBSPQR
mock.onPost(new RegExp(/^\/pimbyzzjlmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jzbspqr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: JZBSPQR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzbspqr$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pimbyzzjlmxid'] == tempValue['pimbyzzjlmxid'] ){
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


// FetchZZWSHDS
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchzzwshds$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchZZWSHDS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchzzwshds$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchZZWSHDS
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchzzwshds$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchZZWSHDS");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchzzwshds$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchZZWSHDS
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchzzwshds$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchZZWSHDS");
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

// FetchZZWSHDS
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchzzwshds(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchZZWSHDS");
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


// FetchUnApproved
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchunapproved$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchUnApproved");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchunapproved$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchUnApproved
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchunapproved$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchUnApproved");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchunapproved$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchUnApproved
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchunapproved$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchUnApproved");
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

// FetchUnApproved
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchunapproved(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchUnApproved");
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


// FetchDDJZBSH
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchddjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDDJZBSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchddjzbsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDDJZBSH
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchddjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDDJZBSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchddjzbsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDDJZBSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchddjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDDJZBSH");
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

// FetchDDJZBSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchddjzbsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDDJZBSH");
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


// FetchBYLZZJL
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchbylzzjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchBYLZZJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchbylzzjl$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchBYLZZJL
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchbylzzjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchBYLZZJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchbylzzjl$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchBYLZZJL
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchbylzzjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchBYLZZJL");
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

// FetchBYLZZJL
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchbylzzjl(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchBYLZZJL");
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


// FetchDGSDSZSH
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdgsdszsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDGSDSZSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdgsdszsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDGSDSZSH
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdgsdszsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDGSDSZSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdgsdszsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDGSDSZSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdgsdszsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDGSDSZSH");
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

// FetchDGSDSZSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdgsdszsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDGSDSZSH");
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
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchhtry$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchHTRY");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchhtry$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchHTRY
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchhtry$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchHTRY");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchhtry$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchHTRY
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchhtry$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchHTRY");
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
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchhtry(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchHTRY");
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


// FetchDJZBSP
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsp$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDJZBSP
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSP");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsp$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDJZBSP
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdjzbsp$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSP");
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

// FetchDJZBSP
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdjzbsp(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSP");
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


// FetchDSB
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDSB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdsb$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDSB
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDSB");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdsb$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDSB
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdsb$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDSB");
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

// FetchDSB
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdsb(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDSB");
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


// FetchFinishYGBH
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchfinishygbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchFinishYGBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchfinishygbh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchFinishYGBH
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchfinishygbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchFinishYGBH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchfinishygbh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchFinishYGBH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchfinishygbh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchFinishYGBH");
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

// FetchFinishYGBH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchfinishygbh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchFinishYGBH");
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


// FetchDJZBSH
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDJZBSH
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSH");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdjzbsh$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDJZBSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdjzbsh$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSH");
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

// FetchDJZBSH
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdjzbsh(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDJZBSH");
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
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});


// FetchDefault
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimbyygzzsqid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/fetchdefault$/).exec(config.url);
    if(matchArray && matchArray.length >1 && paramArray && paramArray.length >0){
        paramArray.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
    }
    let items = mockDatas ? mockDatas : [];
    if (items.length > 0 && paramArray.length > 0) {
        paramArray.forEach((paramkey: any) => {
            if (tempValue[paramkey] && tempValue[paramkey].indexOf(";") > 0) {
                let keysGrounp: Array<any> = tempValue[paramkey].split(new RegExp(/[\;]/));
                let tempArray: Array<any> = [];
                keysGrounp.forEach((singlekey: any) => {
                    let _items =  items.filter((item: any) => { return item[paramkey] == singlekey });
                   if(_items.length >0){
                    tempArray.push(..._items);
                   }
                })
                items = tempArray;
            } else {
                items = items.filter((item: any) => { return item[paramkey] == tempValue[paramkey] });
            }
        })
    }
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(items);
    console.groupEnd();
    console.groupEnd();
    return [status, items];
});
    
// FetchDefault
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDefault");
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
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: FetchDefault");
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

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现


// Get
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyygzzsqid','pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyygzzsqs\/([a-zA-Z0-9\-\;]{1,35})\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pimbyzzjlmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimbyzzjlmxid'];
    const matchArray:any = new RegExp(/^\/pimbyzzjlmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pimbyzzjlmxid, tempValue.pimbyzzjlmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
