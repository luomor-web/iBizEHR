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
        prop: 'parldndlhmbmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parldndlhmbmxname',
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
        name: 'parldndlhmbid',
        prop: 'parldndlhmbid',
        dataType: 'PICKUP',
      },
      {
        name: 'parldndlhmbname',
        prop: 'parldndlhmbname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'mblx',
        prop: 'mblx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parldndlhmbmxname',
        prop: 'parldndlhmbmxname',
        dataType: 'TEXT',
      },
      {
        name: 'mblhyq',
        prop: 'mblhyq',
        dataType: 'TEXT',
      },
      {
        name: 'fz',
        prop: 'fz',
        dataType: 'FLOAT',
      },
      {
        name: 'khbf',
        prop: 'khbf',
        dataType: 'TEXT',
      },
      {
        name: 'parldndlhmbmxid',
        prop: 'parldndlhmbmxid',
        dataType: 'GUID',
      },
      {
        name: 'parldndlhmbmx',
        prop: 'parldndlhmbmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}