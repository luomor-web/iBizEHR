/**
 * NDLHMBKH 部件模型
 *
 * @export
 * @class NDLHMBKHModel
 */
export default class NDLHMBKHModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof NDLHMBKHModel
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
        prop: 'parldndlhmbid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parldndlhmbname',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'sstz',
        prop: 'sstz',
        dataType: 'TEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sszz',
        prop: 'sszz',
        dataType: 'TEXT',
      },
      {
        name: 'ssbm',
        prop: 'ssbm',
        dataType: 'TEXT',
      },
      {
        name: 'jxjd',
        prop: 'jxjd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parldndlhmbid',
        prop: 'parldndlhmbid',
        dataType: 'GUID',
      },
      {
        name: 'parldndlhmb',
        prop: 'parldndlhmbid',
        dataType: 'FONTKEY',
      },
    ]
  }

}