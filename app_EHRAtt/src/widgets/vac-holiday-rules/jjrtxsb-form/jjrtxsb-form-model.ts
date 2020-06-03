/**
 * JJRTXSB 部件模型
 *
 * @export
 * @class JJRTXSBModel
 */
export default class JJRTXSBModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JJRTXSBModel
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