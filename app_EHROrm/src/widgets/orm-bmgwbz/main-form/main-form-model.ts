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
        prop: 'ormbmgwbzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormbmgwbzname',
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
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormgwbzid',
        prop: 'ormgwbzid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormgwbzmc',
        prop: 'ormgwbzmc',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'numcompilation',
        prop: 'numcompilation',
        dataType: 'INT',
      },
      {
        name: 'gwzzsm',
        prop: 'gwzzsm',
        dataType: 'TEXT',
      },
      {
        name: 'ormbmgwbzid',
        prop: 'ormbmgwbzid',
        dataType: 'GUID',
      },
      {
        name: 'ormbmgwbz',
        prop: 'ormbmgwbzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}