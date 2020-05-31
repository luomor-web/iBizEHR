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
        prop: 'pcmgxmlid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmgxmlname',
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
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nationarea',
        prop: 'nationarea',
        dataType: 'TEXT',
      },
      {
        name: 'pcmgxmlname',
        prop: 'pcmgxmlname',
        dataType: 'TEXT',
      },
      {
        name: 'xxxz',
        prop: 'xxxz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcmgxmlid',
        prop: 'pcmgxmlid',
        dataType: 'GUID',
      },
      {
        name: 'pcmgxml',
        prop: 'pcmgxmlid',
        dataType: 'FONTKEY',
      },
    ]
  }

}