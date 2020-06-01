/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'attendancemreportid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'attendancemreportname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yf',
        prop: 'yf',
        dataType: 'SSCODELIST',
      },
      {
        name: 'attendencesetupid',
        prop: 'attendencesetupid',
        dataType: 'PICKUP',
      },
      {
        name: 'attendencesetupname',
        prop: 'attendencesetupname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zt',
        prop: 'zt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'attendancemreportid',
        prop: 'attendancemreportid',
        dataType: 'GUID',
      },
      {
        name: 'attendancemreport',
        prop: 'attendancemreportid',
        dataType: 'FONTKEY',
      },
    ]
  }

}