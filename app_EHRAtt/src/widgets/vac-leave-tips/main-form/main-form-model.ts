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
        prop: 'vacleavetipsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'vacleavetipsname',
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
        dataType: 'PICKUP',
      },
      {
        name: 'vacholidayrulesname',
        prop: 'vacholidayrulesname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'qjzl',
        prop: 'qjzl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'tips',
        prop: 'tips',
        dataType: 'TEXT',
      },
      {
        name: 'vacleavetipsid',
        prop: 'vacleavetipsid',
        dataType: 'GUID',
      },
      {
        name: 'vacleavetips',
        prop: 'vacleavetipsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}