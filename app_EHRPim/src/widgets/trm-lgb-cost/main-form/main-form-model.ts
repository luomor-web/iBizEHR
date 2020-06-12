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
        prop: 'trmlgbcostid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmlgbcostname',
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
        name: 'trmlgbcostname',
        prop: 'trmlgbcostname',
        dataType: 'TEXT',
      },
      {
        name: 'kssj',
        prop: 'kssj',
        dataType: 'DATE',
      },
      {
        name: 'jssj',
        prop: 'jssj',
        dataType: 'DATE',
      },
      {
        name: 'je',
        prop: 'je',
        dataType: 'FLOAT',
      },
      {
        name: 'hdsm',
        prop: 'hdsm',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'memo',
        prop: 'memo',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmlgbcostid',
        prop: 'trmlgbcostid',
        dataType: 'GUID',
      },
      {
        name: 'trmlgbcost',
        prop: 'trmlgbcostid',
        dataType: 'FONTKEY',
      },
    ]
  }

}