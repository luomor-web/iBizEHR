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
        prop: 'parkhfaid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parkhfaname',
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
        name: 'parkhfaname',
        prop: 'parkhfaname',
        dataType: 'TEXT',
      },
      {
        name: 'szsj',
        prop: 'szsj',
        dataType: 'DATE',
      },
      {
        name: 'availableflag',
        prop: 'availableflag',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parkhfaid',
        prop: 'parkhfaid',
        dataType: 'GUID',
      },
      {
        name: 'parkhfa',
        prop: 'parkhfaid',
        dataType: 'FONTKEY',
      },
    ]
  }

}