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
        prop: 'pimstafftypeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimstafftypename',
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
        name: 'sbm',
        prop: 'sbm',
        dataType: 'TEXT',
      },
      {
        name: 'pimstafftypename',
        prop: 'pimstafftypename',
        dataType: 'TEXT',
      },
      {
        name: 'shgz',
        prop: 'shgz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimstafftypeid',
        prop: 'pimstafftypeid',
        dataType: 'GUID',
      },
      {
        name: 'pimstafftype',
        prop: 'pimstafftypeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}