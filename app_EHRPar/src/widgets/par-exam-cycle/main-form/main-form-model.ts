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
        prop: 'parexamcycleid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parexamcyclename',
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
        name: 'cycleid',
        prop: 'cycleid',
        dataType: 'TEXT',
      },
      {
        name: 'parexamcycleid',
        prop: 'parexamcycleid',
        dataType: 'GUID',
      },
      {
        name: 'parexamcyclename',
        prop: 'parexamcyclename',
        dataType: 'TEXT',
      },
      {
        name: 'parexamcycle',
        prop: 'parexamcycleid',
        dataType: 'FONTKEY',
      },
    ]
  }

}