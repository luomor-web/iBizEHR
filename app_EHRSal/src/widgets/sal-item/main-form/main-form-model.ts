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
        prop: 'salitemid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salitemname',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'salitemname',
        prop: 'salitemname',
        dataType: 'TEXT',
      },
      {
        name: 'salsubjectname',
        prop: 'salsubjectname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'salsubjectid',
        prop: 'salsubjectid',
        dataType: 'PICKUP',
      },
      {
        name: 'salitemid',
        prop: 'salitemid',
        dataType: 'GUID',
      },
      {
        name: 'salitem',
        prop: 'salitemid',
        dataType: 'FONTKEY',
      },
    ]
  }

}