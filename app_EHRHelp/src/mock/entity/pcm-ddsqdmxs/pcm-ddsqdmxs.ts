import qs from 'qs';
import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

// 模拟数据
const mockDatas: Array<any> = [
];


//getwflink
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmddsqdmxes\/[a-zA-Z0-9\-\;]+\/usertasks\/[a-zA-Z0-9\-\;]+\/ways$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: getwflink");
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
mock.onGet(new RegExp(/^\/wfcore\/ehr-app-ehrhelp\/pcmddsqdmxes\/process-definitions-nodes$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: getwfstep");
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
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: createBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// updateBatch
mock.onPut(new RegExp(/^\/pcmddsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: updateBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});

// removeBatch
mock.onDelete(new RegExp(/^\/pcmddsqdmxes\/batch$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: removeBatch");
    console.table({url:config.url, method: config.method, data:config.data});
    console.groupEnd();
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, {}];
    }
    return [status, {}];
});



// Select
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});


// Select
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

// Select
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Select");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/select$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items);
    console.groupEnd();
    console.groupEnd();
    return [status, _items];
});

    
// Update
mock.onPut(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPut(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPut(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPut(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Update");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// DDUpdate
mock.onPut(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDUpdate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/).exec(config.url);
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

    
// DDUpdate
mock.onPut(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDUpdate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/).exec(config.url);
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

    
// DDUpdate
mock.onPut(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDUpdate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/).exec(config.url);
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
        
// DDUpdate
mock.onPut(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/ddupdate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDUpdate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddupdate$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// SQBTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/).exec(config.url);
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

    
// SQBTG
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/).exec(config.url);
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

    
// SQBTG
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/).exec(config.url);
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
        
// SQBTG
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/sqbtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQBTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqbtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// JDCZ
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/).exec(config.url);
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

    
// JDCZ
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/).exec(config.url);
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

    
// JDCZ
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/).exec(config.url);
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
        
// JDCZ
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jdcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jdcz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: GetDraft");
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
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: GetDraft");
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
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: GetDraft");
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
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/getdraft$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: GetDraft");
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

    
// Create
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Create");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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

    
// DDCreate
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCreate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/).exec(config.url);
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

    
// DDCreate
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCreate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/).exec(config.url);
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

    
// DDCreate
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCreate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/).exec(config.url);
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
        
// DDCreate
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/ddcreate$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCreate");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcreate$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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







    
// ZZSQ
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: ZZSQ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/).exec(config.url);
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

    
// ZZSQ
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: ZZSQ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/).exec(config.url);
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

    
// ZZSQ
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: ZZSQ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/).exec(config.url);
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
        
// ZZSQ
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/zzsq$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: ZZSQ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/zzsq$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/checkkey$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: CheckKey");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/checkkey$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// DDCZ
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/).exec(config.url);
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

    
// DDCZ
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/).exec(config.url);
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

    
// DDCZ
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/).exec(config.url);
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
        
// DDCZ
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/ddcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: DDCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/ddcz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// SQTG
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/).exec(config.url);
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

    
// SQTG
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/).exec(config.url);
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

    
// SQTG
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/).exec(config.url);
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
        
// SQTG
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/sqtg$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: SQTG");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/sqtg$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/save$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Save");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/save$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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

    
// JZCZ
mock.onPost(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/).exec(config.url);
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

    
// JZCZ
mock.onPost(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/).exec(config.url);
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

    
// JZCZ
mock.onPost(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/).exec(config.url);
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
        
// JZCZ
mock.onPost(new RegExp(/^\/pcmddsqdmxes\/?([a-zA-Z0-9\-\;]{0,35})\/jzcz$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: JZCZ");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})\/jzcz$/).exec(config.url);
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
    //let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
      let data = JSON.parse(config.data);
    mockDatas.forEach((item)=>{
        if(item['pcmddsqdmxid'] == tempValue['pcmddsqdmxid'] ){
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


// FetchJZSQMX
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/).exec(config.url);
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


// FetchJZSQMX
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/).exec(config.url);
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


// FetchJZSQMX
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqmx$/).exec(config.url);
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
    
// FetchJZSQMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjzsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQMX");
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

// FetchJZSQMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjzsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQMX");
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


// FetchJDSQGR
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/).exec(config.url);
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


// FetchJDSQGR
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/).exec(config.url);
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


// FetchJDSQGR
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqgr$/).exec(config.url);
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
    
// FetchJDSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjdsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQGR");
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

// FetchJDSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjdsqgr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQGR");
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
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/).exec(config.url);
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
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/).exec(config.url);
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
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDefault");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchdefault$/).exec(config.url);
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
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchdefault$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDefault");
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
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchdefault(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDefault");
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


// FetchJDSQMX
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/).exec(config.url);
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


// FetchJDSQMX
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/).exec(config.url);
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


// FetchJDSQMX
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjdsqmx$/).exec(config.url);
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
    
// FetchJDSQMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjdsqmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQMX");
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

// FetchJDSQMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjdsqmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJDSQMX");
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


// FetchDDJL
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/).exec(config.url);
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


// FetchDDJL
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/).exec(config.url);
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


// FetchDDJL
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddjl$/).exec(config.url);
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
    
// FetchDDJL
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDJL");
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

// FetchDDJL
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddjl(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDJL");
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


// FetchGBDDJL
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchGBDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/).exec(config.url);
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


// FetchGBDDJL
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchGBDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/).exec(config.url);
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


// FetchGBDDJL
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchGBDDJL");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchgbddjl$/).exec(config.url);
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
    
// FetchGBDDJL
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchgbddjl$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchGBDDJL");
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

// FetchGBDDJL
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchgbddjl(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchGBDDJL");
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


// FetchDDSQGR
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/).exec(config.url);
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


// FetchDDSQGR
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/).exec(config.url);
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


// FetchDDSQGR
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddsqgr$/).exec(config.url);
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
    
// FetchDDSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDSQGR");
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

// FetchDDSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddsqgr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDSQGR");
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


// FetchDDMX
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/).exec(config.url);
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


// FetchDDMX
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/).exec(config.url);
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


// FetchDDMX
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDMX");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchddmx$/).exec(config.url);
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
    
// FetchDDMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddmx$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDMX");
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

// FetchDDMX
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchddmx(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchDDMX");
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


// FetchJZSQGR
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/).exec(config.url);
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


// FetchJZSQGR
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pimdistirbutionid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/).exec(config.url);
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


// FetchJZSQGR
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQGR");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }
    const paramArray:Array<any> = ['pcmddsqdid'];
    let tempValue: any = {};
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/fetchjzsqgr$/).exec(config.url);
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
    
// FetchJZSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjzsqgr$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQGR");
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

// FetchJZSQGR
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/fetchjzsqgr(\?[\w-./?%&=,]*)*$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: FetchJZSQGR");
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

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现

// URI参数传递情况未实现
// URI参数传递情况未实现


// Get
mock.onGet(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Get
mock.onGet(new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Get");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimpersonid','pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimpeople\/([a-zA-Z0-9\-\;]{1,35})\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pimdistirbutionid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pimdistirbutions\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdid','pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqds\/([a-zA-Z0-9\-\;]{1,35})\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});

// Remove
mock.onDelete(new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/)).reply((config: any) => {
    console.groupCollapsed("实体:pcmddsqdmx 方法: Remove");
    console.table({url:config.url, method: config.method, data:config.data});
    let status = MockAdapter.mockStatus(config);
    if (status !== 200) {
        return [status, null];
    }    
    const paramArray:Array<any> = ['pcmddsqdmxid'];
    const matchArray:any = new RegExp(/^\/pcmddsqdmxes\/([a-zA-Z0-9\-\;]{1,35})$/).exec(config.url);
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
    let _items = items.find((item: any) => Object.is(item.pcmddsqdmxid, tempValue.pcmddsqdmxid));
    console.groupCollapsed("response数据  status: "+status+" data: ");
    console.table(_items?_items:{});
    console.groupEnd();
    console.groupEnd();
    return [status, _items?_items:{}];
});
