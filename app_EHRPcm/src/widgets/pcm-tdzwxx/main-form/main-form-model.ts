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
        prop: 'tdzwxxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'tdzwxxname',
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
        name: 'pcmprofileid',
        prop: 'pcmprofileid',
        dataType: 'PICKUP',
      },
      {
        name: 'jobid',
        prop: 'jobid',
        dataType: 'TEXT',
      },
      {
        name: 'tdzwxxname',
        prop: 'tdzwxxname',
        dataType: 'TEXT',
      },
      {
        name: 'initapplydate',
        prop: 'initapplydate',
        dataType: 'DATE',
      },
      {
        name: 'department',
        prop: 'department',
        dataType: 'TEXT',
      },
      {
        name: 'phaseinfo',
        prop: 'phaseinfo',
        dataType: 'TEXT',
      },
      {
        name: 'statusinfo',
        prop: 'statusinfo',
        dataType: 'TEXT',
      },
      {
        name: 'tdzwxxid',
        prop: 'tdzwxxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmtdzwxx',
        prop: 'tdzwxxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}