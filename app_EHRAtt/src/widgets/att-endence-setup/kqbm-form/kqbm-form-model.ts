/**
 * KQBM 部件模型
 *
 * @export
 * @class KQBMModel
 */
export default class KQBMModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof KQBMModel
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
        prop: 'attendencesetupid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'attendencesetupname',
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
        name: 'attendencesetupid',
        prop: 'attendencesetupid',
        dataType: 'GUID',
      },
      {
        name: 'attendencesetup',
        prop: 'attendencesetupid',
        dataType: 'FONTKEY',
      },
    ]
  }

}