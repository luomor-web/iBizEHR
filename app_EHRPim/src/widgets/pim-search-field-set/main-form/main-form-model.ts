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
        prop: 'pimsearchfieldsetid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimsearchfieldsetname',
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
        name: 'pimsearchfieldsetname',
        prop: 'pimsearchfieldsetname',
        dataType: 'TEXT',
      },
      {
        name: 'entityname',
        prop: 'entityname',
        dataType: 'TEXT',
      },
      {
        name: 'entitylogicname',
        prop: 'entitylogicname',
        dataType: 'TEXT',
      },
      {
        name: 'columnlogicname',
        prop: 'columnlogicname',
        dataType: 'TEXT',
      },
      {
        name: 'columnname',
        prop: 'columnname',
        dataType: 'TEXT',
      },
      {
        name: 'tname',
        prop: 'tname',
        dataType: 'TEXT',
      },
      {
        name: 'vname',
        prop: 'vname',
        dataType: 'TEXT',
      },
      {
        name: 'fieldtype',
        prop: 'fieldtype',
        dataType: 'TEXT',
      },
      {
        name: 'searchtag',
        prop: 'searchtag',
        dataType: 'YESNO',
      },
      {
        name: 'isshown',
        prop: 'isshown',
        dataType: 'YESNO',
      },
      {
        name: 'columnwidth',
        prop: 'columnwidth',
        dataType: 'INT',
      },
      {
        name: 'pxh',
        prop: 'pxh',
        dataType: 'INT',
      },
      {
        name: 'codelistid',
        prop: 'codelistid',
        dataType: 'TEXT',
      },
      {
        name: 'pimsearchfieldsetid',
        prop: 'pimsearchfieldsetid',
        dataType: 'GUID',
      },
      {
        name: 'pimsearchfieldset',
        prop: 'pimsearchfieldsetid',
        dataType: 'FONTKEY',
      },
    ]
  }

}