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
        prop: 'pimqualmajorid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'zyzgzy',
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
        name: 'gwlx',
        prop: 'gwlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zyzgzy',
        prop: 'zyzgzy',
        dataType: 'TEXT',
      },
      {
        name: 'pimqualmajorname',
        prop: 'pimqualmajorname',
        dataType: 'TEXT',
      },
      {
        name: 'qualevel',
        prop: 'qualevel',
        dataType: 'TEXT',
      },
      {
        name: 'quamajor',
        prop: 'quamajor',
        dataType: 'TEXT',
      },
      {
        name: 'gwtype',
        prop: 'gwtype',
        dataType: 'TEXT',
      },
      {
        name: 'gwzs',
        prop: 'gwzs',
        dataType: 'TEXT',
      },
      {
        name: 'pimqualmajorid',
        prop: 'pimqualmajorid',
        dataType: 'GUID',
      },
      {
        name: 'pimqualmajor',
        prop: 'pimqualmajorid',
        dataType: 'FONTKEY',
      },
    ]
  }

}