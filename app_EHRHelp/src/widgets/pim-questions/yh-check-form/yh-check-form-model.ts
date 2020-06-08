/**
 * YH_Check 部件模型
 *
 * @export
 * @class YH_CheckModel
 */
export default class YH_CheckModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YH_CheckModel
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
        prop: 'questionsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'questionsname',
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
        name: 'wtbh',
        prop: 'wtbh',
        dataType: 'TEXT',
      },
      {
        name: 'questionsname',
        prop: 'questionsname',
        dataType: 'TEXT',
      },
      {
        name: 'jjcd',
        prop: 'jjcd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ym',
        prop: 'ym',
        dataType: 'TEXT',
      },
      {
        name: 'wtms',
        prop: 'wtms',
        dataType: 'TEXT',
      },
      {
        name: 'jt',
        prop: 'jt',
        dataType: 'TEXT',
      },
      {
        name: 'wtzt',
        prop: 'wtzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'kfz',
        prop: 'kfz',
        dataType: 'TEXT',
      },
      {
        name: 'wcsj',
        prop: 'wcsj',
        dataType: 'DATETIME',
      },
      {
        name: 'wtfk',
        prop: 'wtfk',
        dataType: 'TEXT',
      },
      {
        name: 'questionsid',
        prop: 'questionsid',
        dataType: 'GUID',
      },
      {
        name: 'pimquestions',
        prop: 'questionsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}