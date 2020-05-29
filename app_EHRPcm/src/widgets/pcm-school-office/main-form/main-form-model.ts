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
        prop: 'pcmschoolofficeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmschoolofficename',
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
        name: 'cadrename',
        prop: 'cadrename',
        dataType: 'TEXT',
      },
      {
        name: 'cadrestartdatetime',
        prop: 'cadrestartdatetime',
        dataType: 'DATE',
      },
      {
        name: 'cadreenddatetime',
        prop: 'cadreenddatetime',
        dataType: 'DATE',
      },
      {
        name: 'cadredescription',
        prop: 'cadredescription',
        dataType: 'TEXT',
      },
      {
        name: 'pcmschoolofficeid',
        prop: 'pcmschoolofficeid',
        dataType: 'GUID',
      },
      {
        name: 'pcmschooloffice',
        prop: 'pcmschoolofficeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}