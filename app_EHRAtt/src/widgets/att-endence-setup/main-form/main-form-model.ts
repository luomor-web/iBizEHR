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
        prop: 'attendencesetupid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'attendencesetupname',
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
        name: 'attendencesetupname',
        prop: 'attendencesetupname',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'vacholidayrulesid',
        prop: 'vacholidayrulesid',
        dataType: 'PICKUP',
      },
      {
        name: 'vacholidayrulesname',
        prop: 'vacholidayrulesname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sbsj',
        prop: 'sbsj',
        dataType: 'TIME',
      },
      {
        name: 'xbsj',
        prop: 'xbsj',
        dataType: 'TIME',
      },
      {
        name: 'dkfs',
        prop: 'dkfs',
        dataType: 'SSCODELIST',
      },
      {
        name: 'allowoutwork',
        prop: 'allowoutwork',
        dataType: 'SSCODELIST',
      },
      {
        name: 'attendencesetupid',
        prop: 'attendencesetupid',
        dataType: 'GUID',
      },
      {
        name: 'attendencesetup',
        prop: 'attendencesetupid',
        dataType: 'FONTKEY',
      },
    ]
  }

}