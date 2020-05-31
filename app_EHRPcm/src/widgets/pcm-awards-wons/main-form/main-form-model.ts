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
        prop: 'pcmawardswonsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmawardswonsname',
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
        name: 'awardname',
        prop: 'awardname',
        dataType: 'TEXT',
      },
      {
        name: 'awardtime',
        prop: 'awardtime',
        dataType: 'DATE',
      },
      {
        name: 'awardlevel',
        prop: 'awardlevel',
        dataType: 'SSCODELIST',
      },
      {
        name: 'judgeorg',
        prop: 'judgeorg',
        dataType: 'TEXT',
      },
      {
        name: 'pcmawardswonsid',
        prop: 'pcmawardswonsid',
        dataType: 'GUID',
      },
      {
        name: 'pcmawardswons',
        prop: 'pcmawardswonsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}