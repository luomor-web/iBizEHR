/**
 * GREditForm 部件模型
 *
 * @export
 * @class GREditFormModel
 */
export default class GREditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GREditFormModel
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
        prop: 'pimpaperid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpapername',
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
        name: 'pimpapername',
        prop: 'pimpapername',
        dataType: 'TEXT',
      },
      {
        name: 'cbshkwmc',
        prop: 'cbshkwmc',
        dataType: 'TEXT',
      },
      {
        name: 'fbsj',
        prop: 'fbsj',
        dataType: 'DATE',
      },
      {
        name: 'grzlwzzzdpm',
        prop: 'grzlwzzzdpm',
        dataType: 'INT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'pimpaperid',
        prop: 'pimpaperid',
        dataType: 'GUID',
      },
      {
        name: 'pimpaper',
        prop: 'pimpaperid',
        dataType: 'FONTKEY',
      },
    ]
  }

}