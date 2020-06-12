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
        prop: 'pimresearchfindingsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimresearchfindingsname',
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
        name: 'pimresearchfindingsname',
        prop: 'pimresearchfindingsname',
        dataType: 'TEXT',
      },
      {
        name: 'hqsj',
        prop: 'hqsj',
        dataType: 'DATE',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'pimresearchfindingsid',
        prop: 'pimresearchfindingsid',
        dataType: 'GUID',
      },
      {
        name: 'pimresearchfindings',
        prop: 'pimresearchfindingsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}