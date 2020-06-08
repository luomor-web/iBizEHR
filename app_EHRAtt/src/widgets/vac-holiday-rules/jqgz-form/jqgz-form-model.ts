/**
 * JQGZ 部件模型
 *
 * @export
 * @class JQGZModel
 */
export default class JQGZModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JQGZModel
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
        prop: 'vacholidayrulesid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'vacholidayrulesname',
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
        name: 'vacholidayrulesname',
        prop: 'vacholidayrulesname',
        dataType: 'TEXT',
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
        name: 'sfqy',
        prop: 'sfqy',
        dataType: 'SSCODELIST',
      },
      {
        name: 'vacholidayrulesid',
        prop: 'vacholidayrulesid',
        dataType: 'GUID',
      },
      {
        name: 'vacholidayrules',
        prop: 'vacholidayrulesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}