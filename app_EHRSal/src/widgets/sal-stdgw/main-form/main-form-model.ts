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
        prop: 'salstdgwid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salstdgwname',
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
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'qssj',
        prop: 'qssj',
        dataType: 'DATE',
      },
      {
        name: 'jssj',
        prop: 'jssj',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'FLOAT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'salstdgwid',
        prop: 'salstdgwid',
        dataType: 'GUID',
      },
      {
        name: 'salstdgw',
        prop: 'salstdgwid',
        dataType: 'FONTKEY',
      },
    ]
  }

}