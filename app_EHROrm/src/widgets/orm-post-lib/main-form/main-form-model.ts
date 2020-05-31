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
        prop: 'ormpostlibid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormpostlibname',
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
        name: 'gwtype',
        prop: 'gwtype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormpostlibname',
        prop: 'ormpostlibname',
        dataType: 'TEXT',
      },
      {
        name: 'gwflag',
        prop: 'gwflag',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sugexcyear',
        prop: 'sugexcyear',
        dataType: 'INT',
      },
      {
        name: 'mustexcyear',
        prop: 'mustexcyear',
        dataType: 'INT',
      },
      {
        name: 'isconfidential',
        prop: 'isconfidential',
        dataType: 'SSCODELIST',
      },
      {
        name: 'postnature',
        prop: 'postnature',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jobdesc',
        prop: 'jobdesc',
        dataType: 'TEXT',
      },
      {
        name: 'ormpostlibid',
        prop: 'ormpostlibid',
        dataType: 'GUID',
      },
      {
        name: 'ormpostlib',
        prop: 'ormpostlibid',
        dataType: 'FONTKEY',
      },
    ]
  }

}